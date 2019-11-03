import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { ToDoListSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective } from './';

@NgModule({
  imports: [ToDoListSharedCommonModule],
  declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
  entryComponents: [JhiLoginModalComponent],
  exports: [ToDoListSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ToDoListSharedModule {
  static forRoot() {
    return {
      ngModule: ToDoListSharedModule
    };
  }
}
