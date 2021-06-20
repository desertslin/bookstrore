package com.deserts.bean;

import java.util.List;

/**
 * @ClassName Page
 * @Description TODO
 * @Author deserts
 * @Date 2020/8/16 11:11
 */
public class Page<T> {
    /**
     * 表示当前第几页
     */
    private int pageNo;
    /**
     * 总页码
     */
    private int totalPage;
    /**
     * 总记录数
     */
    private int totalCount;
    /**
     * 每页显示的记录数
     */
    private int pageSize = 4;
    /**
     * 指定开始的索引
     */
    private int index;
    /**
     * 表示是否有下一页
     */
    private boolean hasNext;
    /**
     * 表示是否有上一页
     */
    private boolean hasPrev;
    /**
     * 分页实际查出来的数据
     */
    private List<T> pageData;

    /**
     * 分页条的地址
     */
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Page() {
    }

    public Page(int pageNo, int totalPage, int totalCount, int pageSize, int index, boolean hasNext, boolean hasPrev, List<T> pageData, String url) {
        this.pageNo = pageNo;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.index = index;
        this.hasNext = hasNext;
        this.hasPrev = hasPrev;
        this.pageData = pageData;
        this.url = url;
    }

    public int getPageNo() { return pageNo; }

    public void setPageNo(int pageNo) {
        pageNo = pageNo > 0 ? pageNo : 1;
        pageNo = Math.min(pageNo, getTotalPage());
        this.pageNo = pageNo;
    }

    public int getTotalPage() {
        int t = getTotalCount()/getPageSize();
        if (getTotalCount() % getPageSize() != 0){
            t += 1;
        }
        return t;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize){
        this.pageSize = pageSize;
    }

    public int getIndex() {
        int i = (getPageNo() - 1) * getPageSize();
        return i;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isHasNext() {
        return getPageNo() < getTotalPage();
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public boolean isHasPrev() {
        return getPageNo() > 1;
    }

    public void setHasPrev(boolean hasPrev) {
        this.hasPrev = hasPrev;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", index=" + index +
                ", hasNext=" + hasNext +
                ", hasPrev=" + hasPrev +
                ", pageData=" + pageData +
                '}';
    }
}
