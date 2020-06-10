import { Component, OnInit } from '@angular/core';
import { ProductCategory } from 'src/app/models/product-category';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-category-list',
  templateUrl: './product-category-list.component.html',
  styleUrls: ['./product-category-list.component.css']
})
export class ProductCategoryListComponent implements OnInit {
  Categories:ProductCategory[];

  constructor(public apiservice:ProductService) { }

  ngOnInit(): void {
    this.getCategories()
  }

  getCategories(){
    this.apiservice.getProductsCategory().subscribe(
      data => this.Categories = data
    )
  }


}
