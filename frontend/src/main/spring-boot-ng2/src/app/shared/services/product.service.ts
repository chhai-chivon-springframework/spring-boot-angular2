import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import {API_PRODUCT} from "../constants/api.path.constant";

@Injectable()
export class ProductService {

  constructor(private http: Http) {

  }

  private httpGetMap(url){
    return this.http.get(url).map(res => res.json());
  }

  public getAll(){
    return this.httpGetMap(API_PRODUCT);
  }

  public getById(id){
    return  this.httpGetMap(API_PRODUCT + '/' + id);
  }

  public create(data){
    return this.http.post(API_PRODUCT,data)
      .map(res =>  res.json());
  }

  public updateById(id,data){
    return this.http.put(API_PRODUCT + '/'+ id , data)
      .map(res => res.json());
  }

  public deleteById(id){
    return this.http.delete(API_PRODUCT + '/'+ id)
      .map(res =>  res.json());
  }
}
