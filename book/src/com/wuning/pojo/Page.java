package com.wuning.pojo;

import java.util.List;

/**
 * @author wu
 * @date 2020-04-22 14:06
 */
public class Page<T> {
    public static final Integer PAGE_SIZE = 4;
    private Integer pageNO;
    private Integer pageToal;
    private Integer pageSize = PAGE_SIZE;
    private Integer pageTotalCount;
    private List<T> items;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPageNO() {
        return pageNO;
    }

    public void setPageNO(Integer pageNO) {

        if (pageNO < 0) {
            pageNO = 1;
        }
        if (pageNO > pageToal) {
            pageNO = pageToal;
        }
        this.pageNO = pageNO;
    }

    public Integer getPageToal() {
        return pageToal;
    }

    public void setPageToal(Integer pageToal) {
        this.pageToal = pageToal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNO=" + pageNO +
                ", pageToal=" + pageToal +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
