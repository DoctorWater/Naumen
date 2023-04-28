import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {UserListComponent} from '../user-list/user-list.component';
import {OldestComponent} from "../oldest/oldest.component";

const routes: Routes = [
  {path: 'users', component: UserListComponent},
  {path: 'oldest', component: OldestComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
