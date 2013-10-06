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

    private long currentPage = 0;
    private Iterable<TItem> currentItems;
    private long numberOfItemsPerPage = 10;
    private long totalNumberOfItems = 0;
    
    public PagedResult(long currentPage, Iterable<TItem> currentItems, long numberOfItemsPerPage, long totalNumberOfItems) {
        this.currentPage = currentPage;
        this.currentItems = currentItems;
        this.numberOfItemsPerPage = numberOfItemsPerPage;
        this.totalNumberOfItems = totalNumberOfItems;
    }
    
    @Override
    public long getCurrentPage() {
        return currentPage;
    }

    @Override
    public long getTotalNumberOfPages() {
        long basicNumberOfPages = totalNumberOfItems / numberOfItemsPerPage;
        long rest = (totalNumberOfItems - (basicNumberOfPages * numberOfItemsPerPage));
        return basicNumberOfPages + (rest == 0 ? 0 : 1);
    }

    @Override
    public Iterable<TItem> getCurrentItems() {
        return currentItems;
    }

    @Override
    public long getNumberOfItemsPerPage() {
        return numberOfItemsPerPage;
    }

    @Override
    public long getTotalNumberOfItems() {
        return totalNumberOfItems;
    }
    
}
