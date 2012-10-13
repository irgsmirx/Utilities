/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.paging.implementation;

import com.ramforth.utilities.paging.interfaces.IPagedResult;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class PagedResult<TItem> implements IPagedResult<TItem> {

    private int currentPage = 0;
    private Iterable<TItem> currentItems;
    private int numberOfItemsPerPage = 0;
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
        int basicNumberOfPages = totalNumberOfItems / numberOfItemsPerPage;
        int rest = (totalNumberOfItems - (basicNumberOfPages * numberOfItemsPerPage));
        return basicNumberOfPages + (rest == 0 ? 0 : 1);
    }

    @Override
    public Iterable<TItem> getCurrentItems() {
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
