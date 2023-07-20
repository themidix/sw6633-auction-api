package edu.ksu.sw6633auctionapi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="categories")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id", nullable = false)
    private Long categoryId;
    @Column(name = "category_name", nullable = false, length = 64)
    private String categoryName;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<AuctionItem> auctionItems;
    public Category() {

    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(Long categoryId, String categoryName, List<AuctionItem> auctionItems) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.auctionItems = auctionItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return Objects.equals(getCategoryId(), category.getCategoryId()) && Objects.equals(getCategoryName(), category.getCategoryName()) && Objects.equals(auctionItems, category.auctionItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategoryId(), getCategoryName(), auctionItems);
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", auctionItems=" + auctionItems +
                '}';
    }

    public Long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<AuctionItem> getAuctionItems() {
        return auctionItems;
    }

    public void setAuctionItems(List<AuctionItem> auctionItems) {
        this.auctionItems = auctionItems;
    }
}
