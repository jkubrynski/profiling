package com.kubrynski.profiling.repository;

import com.kubrynski.profiling.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-07-03
 */
public interface ShopRepository extends JpaRepository<Shop, Long> {
}
