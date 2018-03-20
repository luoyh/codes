import java.util.List;
import java.util.Map;

import org.springframework.util.Assert;

import com.google.common.collect.Maps;

/**
 * <p>Created: Mar 20, 2018 3:31:19 PM</p>
 * 
 * @author luoyh(Roy)
 * @version 1.0
 * @since 1.8
 */
public class Pageable<T> {

    public static final int DEFAULT_START = 1;  // pages start begin 1
    public static final int DEFAULT_SIZE = 20;
    
    public static enum Order {
        ASE, DESC;
    }
    
    private int start = DEFAULT_START;
    private int size = DEFAULT_SIZE;
    private int pages;
    private int total;
    private List<T> data;
    
    private Map<String, Object> param = Maps.newHashMap();
    private Map<String, Order> order = Maps.newLinkedHashMap();  // rank
    
    
    public static <T> Pageable<T> me() {
        return new Pageable<T>();
    }
    
    public Pageable<T> param(String key, Object value) {
        Assert.notNull(key);
        Assert.notNull(value);
        
        getParam().put(key, value);
        
        return this;
    }
    
    public Pageable<T> order(String column, Order order) {
        Assert.notNull(column);
        Assert.notNull(order);
        
        getOrder().put(column, order);
        
        return this;
    }
    
    
    // getter/setter
    
    public int getStart() {
        return start;
    }
    public void setStart(int start) {
        // minimums with DEFAULT_START
        this.start = start < DEFAULT_START ? DEFAULT_START : start;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        // size must be > 0
        this.size = size < 0 ? DEFAULT_SIZE : size;
    }
    public int getPages() {
        pages = total / size + (total % size == 0 ? 0 : 1);
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public List<T> getData() {
        return data;
    }
    public void setData(List<T> data) {
        this.data = data;
    }
    public Map<String, Object> getParam() {
        return param;
    }
    public void setParam(Map<String, Object> param) {
        this.param = param;
    }
    public Map<String, Order> getOrder() {
        return order;
    }
    public void setOrder(Map<String, Order> order) {
        this.order = order;
    }
    
}
