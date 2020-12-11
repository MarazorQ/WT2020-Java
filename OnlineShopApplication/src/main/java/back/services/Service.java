package services;

import dao.*;
import entity.CartEntity;
import entity.RoleEntity;
import entity.ToyEntity;
import entity.UserEntity;

import java.util.List;

public class Service {
    private final UserDao userDao = new UserDao();
    private final ToyDao toyDao = new toyDao();
    private final CartDao cartDao = new CartDao();

    public boolean signin(UserEntity userEntity) throws ServiceException {
        Filter filter = new Filter();
        filter.setEmail(userEntity.getEmail());
        UserEntity existingUser;

        try {
            existingUser = userDao.getList(filter).stream().findFirst().orElse(null);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

        if (existingUser == null || !existingUser.getPassword().equals(userEntity.getPassword())) {
            return false;
        }

        userEntity.setId(existingUser.getId());
        userEntity.setName(existingUser.getName());
        userEntity.setRole(existingUser.getRole());

        return true;
    }

    public boolean signup(UserEntity user) throws ServiceException {
        Filter filter = new Filter();
        filter.setEmail(user.getEmail());
        UserEntity existingUser;
        try {
            existingUser = userDao.getList(filter).stream().findFirst().orElse(null);
            if (existingUser != null) {
                return false;
            }
            userDao.add(user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return true;
    }

    public List<toyEntity> gettoys(UserEntity userEntity) throws ServiceException {
        Filter filter = new Filter();
        if (userEntity.getRole() == RoleEntity.Customer) {
            filter.setCustomerId(userEntity.getId());
        }

        try {
            return toyDao.getList(filter);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void savetoy(toyEntity toy) throws ServiceException {
        try {
            toyDao.add(toy);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void saveToCart(UserEntity user, List<CartEntity> carts, String cart) throws ServiceException {
        try {
            for (CartEntity _cart : carts) {
                cartDao.add(_cart);
            }

        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }


    public List<CartEntity> getCarts(toyEntity toy, String id) throws ServiceException {
        Filter filter = new Filter();
        filter.settoyId(toy.getId());
        filter.setCustomerId(Integer.valueOf(id));

        try {
            return cartDao.getList(filter);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void deletetoy(int toyId) throws ServiceException {
        toyEntity toy = new toyEntity();
        toy.setId(toyId);

        try {
            toyDao.delete(toy);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<UserEntity> gettoy(String toyId) throws ServiceException {
        Filter filter = new Filter();
        filter.settoyId(Integer.parseInt(toyId));
        try {
            return userDao.getList(filter);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
