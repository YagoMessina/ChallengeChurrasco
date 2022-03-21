package com.yago.churrasco.repository;

import com.yago.churrasco.entity.Product;
import com.yago.churrasco.error.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Product save(Product product) {
        entityManager.persist(product);
        return product;
    }

    public Product findById(Integer id) {
        String stringQuery = "FROM Product p WHERE p.id = :id";
        TypedQuery<Product> query = entityManager.createQuery(stringQuery, Product.class);
        query.setParameter("id", id);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Product not found.", "No product found with id " + id + ".");
        }
    }

    public List<Product> findByFilter(Map<String, String> filters) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);

        try {
            List<Predicate> predicates = new ArrayList<>();
            filters.forEach((k,v) -> predicates.add(criteriaBuilder.equal(root.get(k), v)));
            Predicate[] predicateArray = predicates.toArray(new Predicate[0]);
            criteriaQuery.where(predicateArray);
            TypedQuery<Product> query = entityManager.createQuery(criteriaQuery);
            return query.getResultList();
        } catch (IllegalArgumentException e) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Invalid filter.", "Valid filters are: SKU, code, name," +
                    " description, picture, price, currency.");
        }
    }
}
