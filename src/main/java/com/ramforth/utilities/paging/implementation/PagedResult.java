/* 
 * Copyright (C) 2014 Tobias Ramforth
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ramforth.utilities.paging.implementation;

import com.ramforth.utilities.paging.interfaces.IPagedResult;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 * @param <TItem> The type of the encapsulated items.
 */
public class PagedResult<TItem> implements IPagedResult<TItem> {

    private int currentPage = 0;
    private final Iterable<TItem> currentItems;
    private int numberOfItemsPerPage = 10;
    private int totalNumberOfItems = 0;
    
    public PagedResult(int currentPage, Iterable<TItem> currentItems, int numberOfItemsPerPage, int totalNumberOfItems) {
        this.currentPage = currentPage;
        this.currentItems = currentItems;
        this.numberOfItemsPerPage = numberOfItemsPerPage;
        this.totalNumberOfItems = totalNumberOfItems;
    }
    
    @Override
    public int getCurrentPage() {
        return currentPage;
    }

    @Override
    public int getTotalNumberOfPages() {
        if (numberOfItemsPerPage == 0) {
            return 0;
        }
        int basicNumberOfPages = totalNumberOfItems / numberOfItemsPerPage;
        int rest = (totalNumberOfItems - (basicNumberOfPages * numberOfItemsPerPage));
        return basicNumberOfPages + (rest == 0 ? 0 : 1);
    }

    @Override
    public final Iterable<TItem> getCurrentItems() {
        return currentItems;
    }

    @Override
    public int getNumberOfItemsPerPage() {
        return numberOfItemsPerPage;
    }

    @Override
    public int getTotalNumberOfItems() {
        return totalNumberOfItems;
    }
    
}
