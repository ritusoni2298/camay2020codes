import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../models/product';
import { map } from 'rxjs/operators';
import { ProductCategory } from '../models/product-category';
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};


@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private baseUrl:string = "http://localhost:8080/";
  constructor(private httpClient:HttpClient) { }
  
  
  getProducts():Observable<Product[]>{
    return this.httpClient.get<GetProductResponse>(this.baseUrl+'/products',httpOptions)
    .pipe(map(response => response._embedded.products));
  }

  getProductsCategory():Observable<ProductCategory[]>{
    return this.httpClient.get<GetProductCategoryResponse>(this.baseUrl+'/product-categories',httpOptions)
    .pipe(map(response => response._embedded.productCategory));
  }

  getProductsByCategory(categoryId:number, currentPage:number, size:number):Observable<GetProductResponse>{
    const searchUrl:string = `${this.baseUrl}/products/search/categoryid?id=${categoryId}&page=${currentPage}&size=${size}`; 
    return this.httpClient.get<GetProductResponse>(searchUrl,httpOptions);
  }

  getProductByKeyword(keyword:string):Observable<Product[]>{
    const searchUrl:string = `${this.baseUrl}/products/search/findbykeyword?keyword=${keyword}`;
    return this.httpClient.get<GetProductResponse>(searchUrl,httpOptions)
    .pipe(map(response => response._embedded.products));
  }



}
interface GetProductResponse{
  _embedded:{
    products:Product[];
  }
  page:{
    size:number,
    totalElements:number,
    totalPages:number,
    number:number
  }
}
interface GetProductCategoryResponse{
  _embedded:{
    productCategory:ProductCategory[];
  }
}
