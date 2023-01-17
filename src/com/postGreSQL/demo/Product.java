package com.postGreSQL.demo;

public class Product {
	private int productId;
	private String productName;
	private String productCheck;
	private String MadeIn;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int productId, String productName, String productCheck, String madeIn) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCheck = productCheck;
		MadeIn = madeIn;
	}
	public Product(String productName, String productCheck, String madeIn) {
		super();
		this.productName = productName;
		this.productCheck = productCheck;
		MadeIn = madeIn;
	}
	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the productCheck
	 */
	public String getProductCheck() {
		return productCheck;
	}
	/**
	 * @param productCheck the productCheck to set
	 */
	public void setProductCheck(String productCheck) {
		this.productCheck = productCheck;
	}
	/**
	 * @return the madeIn
	 */
	public String getMadeIn() {
		return MadeIn;
	}
	/**
	 * @param madeIn the madeIn to set
	 */
	public void setMadeIn(String madeIn) {
		MadeIn = madeIn;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[Product Id : "+this.productId+" ] [Product Name : "+this.productName+" ] [Product Quality : "+this.productCheck+" ] [Product Made In :"+this.MadeIn+" ].";
		
	}	
}