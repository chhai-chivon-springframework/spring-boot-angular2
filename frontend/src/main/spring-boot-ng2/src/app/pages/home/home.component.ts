import 'rxjs/add/operator/map';
import { Http } from '@angular/http';
import { Component, OnInit } from '@angular/core';


import { API_END_POINT } from './../../api/api';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  public categories;
  public products;

  constructor(private http: Http) {

  }

  ngOnInit() {
    this.http.get('http://localhost:9000/api/categories')
    .map(res => res.json())
    .subscribe(res => {
      this.categories = res.DATA;

      console.log(res.DATA);
    });


    this.http.get('http://localhost:9000/api/products')
      .map(res => res.json())
      .subscribe(res => {
        this.products = res.DATA
      })
  }

}
