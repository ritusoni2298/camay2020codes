import { Injectable } from '@angular/core';
import { CartItem } from '../models/cart-item';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  cartItems:CartItem[] =[];
  
  //subject is used to transfer data from one component to another
  totalPrice: Subject<number> = new Subject<number>();
  totalQuantity:Subject<number> = new Subject<number>();

  constructor() { }
  //add to cart 
  addCart(theCartItem:CartItem){
    let alreadyExisting: boolean = false;
    let existingCartItem:CartItem = undefined;

    if(this.cartItems.length>0){
      existingCartItem= this.cartItems.find(tempItem => theCartItem.id === tempItem.id);
      alreadyExisting = true;
    }
    if(existingCartItem!=undefined){
      existingCartItem.quantity++;
      console.log(existingCartItem.name);
    }else{
      this.cartItems.push(theCartItem);
      
    }
    console.log(this.cartItems);
   this.calculatePrice();
  }

  calculatePrice(){
    let tpValue:number=0;
    let tqValue:number=0;
  this.cartItems.forEach(element => {
    
      tpValue +=element.unitPrice * element.quantity;
      tqValue +=element.quantity;
    });
   
    console.log(tpValue);
    console.log(tqValue);
    this.totalPrice.next(tpValue);
    this.totalQuantity.next(tqValue);
  }

}
