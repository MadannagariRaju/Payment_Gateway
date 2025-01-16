import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-furniture-products',
  standalone: false,
  
  templateUrl: './furniture-products.component.html',
  styleUrl: './furniture-products.component.css'
})
export class FurnitureProductsComponent {
  products = [
    { id: 1, name: 'Modern Sofa', description: 'A comfortable and stylish sofa for your living room.', price: 399, image: 'https://dukaan.b-cdn.net/700x700/webp/upload_file_service/b9ad04a1-66fd-4bb8-b82c-7521d140a2ad/e6a259e677860331e4474bd616f1fccf.webp' },
    { id: 2, name: 'Wooden Dining Table', description: 'A classic wooden dining table that seats six people.', price: 599, image: 'https://kuberfurniture.com/wp-content/uploads/2024/08/Solid-Wood-Dining-Table-Set-Wooden-Dining-Table-and-Chair-Sheesham-Wood-1.webp' },
    { id: 3, name: 'Office Chair', description: 'An ergonomic chair for your workspace.', price: 199, image: 'https://savyahome.com/cdn/shop/products/71DNVtkoDoL_1200x.jpg?v=1690213599' },
    { id: 4, name: 'Luxury Bed', description: 'A king-size bed with premium mattress.', price: 899, image: 'https://www.nicemaple.com/cdn/shop/products/image_3a1b5c9b-3288-4364-b679-9379cd4f7b7e_1000x.webp?v=1665508820' },
    { id: 5, name: 'Bookshelf', description: 'A modern bookshelf with multiple compartments.', price: 149, image: 'https://m.media-amazon.com/images/I/81eCEoFXtjL._AC_UF894,1000_QL80_.jpg' },
    { id: 6, name: 'Coffee Table', description: 'A sleek coffee table for your living room.', price: 129, image: 'https://cdn.decornation.in/wp-content/uploads/2020/02/wooden-coffee-table-4-stool.png' },
    { id: 7, name: 'Recliner Chair', description: 'A plush recliner for ultimate comfort.', price: 349, image: 'https://m.media-amazon.com/images/I/61IUBuTSYsL.jpg' },
    { id: 8, name: 'Wardrobe', description: 'A spacious wardrobe with sliding doors.', price: 749, image: 'https://5.imimg.com/data5/SELLER/Default/2024/3/397204034/ED/ZW/JW/16632428/modular-wooden-wardrobe-designing-service-500x500.jpg' },
    { id: 9, name: 'TV Stand', description: 'A modern TV stand with storage.', price: 199, image: 'https://images-cdn.ubuy.co.in/63be015dadaffb1d3d0e9195-wampat-mid-century-modern-tv-stand-for.jpg' },
    { id: 10, name: 'Patio Set', description: 'An outdoor patio set for garden seating.', price: 499, image: 'https://m.media-amazon.com/images/I/51fBQRfEnmL.jpg' }
  ];



}
