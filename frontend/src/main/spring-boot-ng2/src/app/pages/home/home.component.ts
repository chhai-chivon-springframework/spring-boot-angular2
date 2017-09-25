import "rxjs/add/operator/map";
import {Component, OnInit} from "@angular/core";
import {ProductService} from "../../shared/services/product.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  public btnSubmit = 'Create';
  public products;
  public product: FormGroup;

  public required = 'required';

  public errorMessage = {
    productName: 'Product name is required',
    price: 'Price  is required',
    imageUrl: 'Image is required',
    description: 'Description is required'
  };

  constructor(private productService: ProductService) {

  }

  ngOnInit() {
    this.loadProducts();
    this.initProductForm();
  }

  public initProductForm() {
    this.product = new FormGroup({
      id: new FormControl(),
      productName: new FormControl('', Validators.required),
      price: new FormControl('', Validators.required),
      imageUrl: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required)
    });
  }

  public loadProducts() {
    this.productService.getAll()
      .subscribe(res => {
        this.products = res.DATA;
        console.log(res.DATA);
      });
  }

  public showProduct(data) {
    this.productService.deleteById(data.id)
      .subscribe(res => {
        console.log('product by id: ', res.DATA)
      });
  }

  public modifyProduct(data) {
    this.btnSubmit = 'Update';
    this.product.patchValue(data);
    console.log("Data ", this.product.value);
  }

  public createProduct(data) {
    this.productService.create(data)
      .subscribe(res => {
        console.log('create product :', res.DATA);
        this.loadProducts();
      });
  }

  public updateProduct(data) {
    console.log("Product update", data);
    this.productService.updateById(data.id, data)
      .subscribe(res => {
        console.log('update product :', res.DATA);
        this.loadProducts();
      });
  }

  public deleteProduct(data) {
    this.productService.deleteById(data.id)
      .subscribe(res => {
        console.log('delete product id :', res.DATA);
        this.loadProducts();
      });
  }

  public saveFormProduct() {
    console.log("Form status:", this.product.valid);
    if (this.product.valid) {
      if (this.btnSubmit === 'Create') {
        this.createProduct(this.product.value);
      } else {
        this.updateProduct(this.product.value);
      }
      this.resetFormProduct();
    }
  }

  public resetFormProduct() {
    this.btnSubmit = 'Create';
    this.product.reset();
  }

  public formControlHasError(name) {
    // product.get('productName').hasError('required') && product.get('productName').touched
    console.log('status ' , this.product.get(name).getError('required') && this.product.get(name).touched);
    return (this.product.get(name).getError('required') && this.product.get(name).touched);
  }

  public formControlGetError(name) {
    console.log("error name : ", name);
    return this.errorMessage[name];
  }

}

