import { Component, NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { AdminComponent } from "./public/Component/admin/admin.component";
import { AppComponent } from "./app.component";
import { CalculatedTaxComponent } from "./public/Component/calculated-tax/calculated-tax.component";
import { ForbiddenComponent } from "./public/publicComponent/forbidden/forbidden.component";
import { HomeComponent } from "./public/Component/home/home.component";
import { LoginComponent } from "./public/publicComponent/login/login.component";
import { StateComponent } from "./public/Component/state/state.component";
import { TaxComponent } from "./public/Component/tax/tax.component";
import { UserComponent } from "./public/Component/user/user.component";
import { ZoneComponent } from "./public/Component/zone/zone.component";
import { AuthGuard } from "./core/guards/auth.guard";
import { AboutComponent } from "./public/Component/about/about.component";
import { SignUpComponent } from "./public/publicComponent/sign-up/sign-up.component";
import { UserListComponent } from "./public/Component/user-list/user-list.component";

const routes: Routes = [
    { path: 'zones', component: ZoneComponent },
    { path: 'states', component: StateComponent },
    { path: 'tax', component: TaxComponent },
    { path: '', component: AboutComponent},
    { path: 'signUp', component: SignUpComponent},
    { path: 'calTax', component: CalculatedTaxComponent },
    { path: 'userList', component:UserListComponent},
    { path: "adminDashboard", component: AdminComponent, canActivate:[AuthGuard], data:{roles: ['Admin']}},
    { path: "userDashboard", component: UserComponent, canActivate:[AuthGuard], data:{roles: ['User']} },
    { path: "login", component: LoginComponent },
    { path: "forbidden", component: ForbiddenComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }

export const routingComponents = [ZoneComponent, StateComponent,
    HomeComponent,
    TaxComponent,
    CalculatedTaxComponent,
    AdminComponent,
    UserComponent,
    LoginComponent,
    ForbiddenComponent,
    AboutComponent,
    SignUpComponent,
UserListComponent]