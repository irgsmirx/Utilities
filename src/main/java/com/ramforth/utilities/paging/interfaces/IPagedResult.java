/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.paging.interfaces;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public interface IPagedResult<TItem> {
 
    int getCurrentPage();
    int getTotalNumberOfPages();
    Iterable<TItem> getCurrentItems();
    int getNumberOfItemsPerPage();
    int getTotalNumberOfItems();
    
}
