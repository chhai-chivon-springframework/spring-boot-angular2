import {RouterModule, Routes} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";

import {HomeComponent} from "./home/home.component";
import {AboutComponent} from "./about/about.component";
import {ContactComponent} from "./contact/contact.component";
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {ProductComponent} from "./product/product.component";
import {DetailComponent} from "./detail/detail.component";

const routes: Routes = [
  { path: 'home', component:HomeComponent},
  { path: '',   redirectTo: '/home', pathMatch: 'full' },
  { path: 'about', component:AboutComponent},
  { path: 'contact', component:ContactComponent},
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent},
  { path: 'product', component: ProductComponent,
    children: [
      { path: 'detail', component: DetailComponent }
    ]
  }
];
//export const routing = RouterModule.forRoot(routes);
export const routing: ModuleWithProviders = RouterModule.forRoot(routes);

