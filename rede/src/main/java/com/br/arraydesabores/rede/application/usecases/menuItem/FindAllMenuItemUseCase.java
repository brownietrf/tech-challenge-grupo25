package com.br.arraydesabores.rede.application.usecases.menuItem;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.br.arraydesabores.rede.application.criteria.MenuItemCriteria;
import com.br.arraydesabores.rede.application.interfaces.IMenuItemGateway;
import com.br.arraydesabores.rede.application.interfaces.IRestaurantGateway;
import com.br.arraydesabores.rede.domain.model.MenuItem;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindAllMenuItemUseCase {
    private final IMenuItemGateway menuItemGateway;
    private final IRestaurantGateway restaurantGateway;

    public Page<MenuItem> execute(Long restaurantId, MenuItemCriteria criteria) {
        if (restaurantGateway.existsById(restaurantId)) {
            criteria.setRestaurantId(restaurantId);
            return menuItemGateway.findAllByRestaurantId(criteria);
        }
        return Page.empty();
    }

}
