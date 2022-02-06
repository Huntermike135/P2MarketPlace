package com.revature.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table( name="Market_Category")
public class Category {
		@Id
		@Column(name = "category_id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer categoryId;
		@Column(name = "category_name")
		private String categoryName;


		public Category() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Category(Integer categoryId, String categoryName) {
			super();
			this.categoryId = categoryId;
			this.categoryName = categoryName;
		}

		public Integer getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(Integer categoryId) {
			this.categoryId = categoryId;
		}

		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}


		@Override
		public String toString() {
			return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
		}
		
	}

