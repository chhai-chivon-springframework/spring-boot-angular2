import {HttpModule} from "@angular/http";
import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {HashLocationStrategy, LocationStrategy} from "@angular/common";
import { FormsModule, ReactiveFormsModule }   from '@angular/forms';

import {AppComponent} from "./app.component";
import {DropdownModule} from "ng2-bootstrap/dropdown";
import {TabsModule} from "ng2-bootstrap/tabs";
import {NAV_DROPDOWN_DIRECTIVES} from "./shared/nav-dropdown.directive";

import {ChartsModule} from "ng2-charts/ng2-charts";
import {SIDEBAR_TOGGLE_DIRECTIVES} from "./shared/sidebar.directive";
import {AsideToggleDirective} from "./shared/aside.directive";
import {BreadcrumbsComponent} from "./shared/breadcrumb.component";
// Routing Module
import {AppRoutingModule} from "./app.routing";
// Layouts
import {FullLayoutComponent} from "./layouts/full-layout.component";
import {SimpleLayoutComponent} from "./layouts/simple-layout.component";
import {UsersComponent} from "./users/users.component";
import {HomeComponent} from "./pages/home/home.component";
import {HeaderComponent} from "./layouts/frontend/header/header.component";
import {FooterComponent} from "./layouts/frontend/footer/footer.component";
import {ProductService} from "./shared/services/product.service";

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    DropdownModule.forRoot(),
    TabsModule.forRoot(),
    ChartsModule,
    HttpModule
  ],
  declarations: [
    AppComponent,
    FullLayoutComponent,
    SimpleLayoutComponent,
    NAV_DROPDOWN_DIRECTIVES,
    BreadcrumbsComponent,
    SIDEBAR_TOGGLE_DIRECTIVES,
    AsideToggleDirective,
    UsersComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
  ],
  providers: [
    {
      provide: LocationStrategy,
      useClass: HashLocationStrategy
    },
    ProductService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
