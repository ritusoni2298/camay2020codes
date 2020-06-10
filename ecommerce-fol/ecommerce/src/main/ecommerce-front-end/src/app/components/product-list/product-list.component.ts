import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { Product } from 'src/app/models/product';
import { ActivatedRoute } from '@angular/router';
import { CartItem } from 'src/app/models/cart-item';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-grid.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products:Product[];
  categoryId: number;
  totalElements:number;
  currentPage:number = 1;
  size:number=3;
  totalPages:number;
  constructor(public _apiservice:ProductService,public _activatedRoute:ActivatedRoute
    ,public _cartService:CartService) { }


  ngOnInit(): void {
    this._activatedRoute.paramMap.subscribe(()=>{
      this.getProductList();
    })
    
  }

  getProductList(){
    let searchUrl=this._activatedRoute.snapshot.paramMap.has('keyword');
    if(searchUrl){
      this.getProductsBySearch();
    }else{
      this.getProductListByCategory();
    }
  }

  getProductListByCategory(){
    const hasCategoryId:boolean = this._activatedRoute.snapshot.paramMap.has('id');
    if(hasCategoryId){
      this.categoryId = +this._activatedRoute.snapshot.paramMap.get('id');
    }else{
      this.categoryId = 1;
    }
      this._apiservice.getProductsByCategory(this.categoryId,this.currentPage-1,this.size)
    .subscribe(
      this.processingData()
    );
    
    
  }
  processingData() {
   return (data) => {
    console.log(data); 
    console.log(data.page);
    this.products = data._embedded.products;
     this.currentPage = data.page.number+1;
     this.totalElements = data.page.totalElements;
     
   }
  }
  updatePageSize(pageSize:number){
    this.currentPage=1;
    this.getProductList();
  }

  getProductsBySearch(){
    const Keyword:string = this._activatedRoute.snapshot.paramMap.get('keyword');
    if(Keyword){
      this._apiservice.getProductByKeyword(Keyword)
      .subscribe(
        data =>{this.products = data;
        console.log(data);
        })
    }
  }

  addToCart(product:Product){
    const cartItem:CartItem = new CartItem(product);
    this._cartService.addCart(cartItem);
    console.log('hello');
  }

  //service cart service
  //2 methods 1> add to cart 2> update the cart
  //cart-items -> id, name, unitPrice,imageUrl,quantity, 

  //cart-status component
  //functionalities on list
  
  //Subject


}

// components => productCategory => data of categories
//services => /productcategory , /products/search/categoryid?id=101
//routing inside the module.ts file
