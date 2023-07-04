package edu.ksu.sw6633auctionapi.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Long categoryId;
    @Column(name = "category_name", nullable = false, length = 64, unique = true)
    private String categoryName;
    @OneToOne(mappedBy = "category")
    private AuctionItem auctionItem;
    public Category() {

    }
    public Category(Long categoryId, String categoryName, AuctionItem auctionItem) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.auctionItem = auctionItem;
    }
    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", auctionItem=" + auctionItem +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return Objects.equals(categoryId, category.categoryId) && Objects.equals(categoryName, category.categoryName) && Objects.equals(auctionItem, category.auctionItem);
    }
    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryName, auctionItem);
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
    public AuctionItem getAuctionItem() {
        return auctionItem;
    }
    public void setAuctionItem(AuctionItem auctionItem) {
        this.auctionItem = auctionItem;
    }
}
