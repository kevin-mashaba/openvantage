import { Component, OnInit } from '@angular/core';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';
import { LoginModalService, AccountService, Account } from 'app/core';
import { TaskService } from 'app/entities/task';
import { ITask } from 'app/shared/model/task.model';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';

import { filter, map } from 'rxjs/operators';
@Component({
  selector: 'jhi-home',
  templateUrl: './home.component.html',
  styleUrls: ['home.scss']
})
export class HomeComponent implements OnInit {
  account: Account;
  modalRef: NgbModalRef;
  tasks: ITask[];
  allTasks: ITask[];

  constructor(
    private accountService: AccountService,
    private loginModalService: LoginModalService,
    private eventManager: JhiEventManager,
    private taskService: TaskService,
    protected jhiAlertService: JhiAlertService
  ) {}

  loadAll() {
    this.taskService
      .query()
      .pipe(
        filter((res: HttpResponse<ITask[]>) => res.ok),
        map((res: HttpResponse<ITask[]>) => res.body)
      )
      .subscribe(
        (res: ITask[]) => {
          this.tasks = res;
          this.allTasks = res;
        },
        (res: HttpErrorResponse) => this.onError(res.message)
      );
  }

  filter(e) {
    let searchText = e.target.value;
    this.tasks = this.allTasks.filter(task => task.title.includes(searchText) || task.category.includes(searchText));
  }

  ngOnInit() {
    this.accountService.identity().then((account: Account) => {
      this.account = account;
    });
    this.registerAuthenticationSuccess();
  }

  registerAuthenticationSuccess() {
    this.loadAll();
    this.eventManager.subscribe('authenticationSuccess', message => {
      this.accountService.identity().then(account => {
        this.account = account;
      });
    });
  }

  isAuthenticated() {
    return this.accountService.isAuthenticated();
  }

  login() {
    this.modalRef = this.loginModalService.open();
  }

  protected onError(errorMessage: string) {
    this.jhiAlertService.error(errorMessage, null, null);
  }
}
