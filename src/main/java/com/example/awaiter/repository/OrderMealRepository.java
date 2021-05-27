package com.example.awaiter.repository;

import com.example.awaiter.model.MealInOrder;
import com.example.awaiter.model.MealOrderPK;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderMealRepository extends CrudRepository<MealInOrder, MealOrderPK> {

    @Query("delete from MealInOrder m where m.pk.meal.id = :id")
    @Modifying
    void deleteMeal(@Param("id")Long id);

    @Query("delete from MealInOrder m where m.pk.order.id = :id")
    @Modifying
    void deleteMealByOrder(@Param("id")Long id);
}
