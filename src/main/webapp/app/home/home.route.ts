import { Route, Routes } from '@angular/router';

import { HomeComponent } from './';
import { TaskDeletePopupComponent, TaskResolve } from 'app/entities/task';
import { UserRouteAccessService } from 'app/core';
export const HOME_ROUTE: Route = {
  path: '',
  component: HomeComponent,
  data: {
    authorities: [],
    pageTitle: 'Welcome, Java Hipster!'
  }
};

export const HOME_POPUP: Route = {
  path: 'home',
  component: HomeComponent,
  data: {
    authorities: [],
    pageTitle: 'Welcome, Java Hipster!'
  }
};

export const homePopupRoute: Routes = [
  {
    path: 'home/:id/delete',
    component: TaskDeletePopupComponent,
    resolve: {
      task: TaskResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Tasks'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];
