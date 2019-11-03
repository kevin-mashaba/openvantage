import { Moment } from 'moment';

export interface ITask {
  id?: number;
  title?: string;
  category?: string;
  description?: string;
  date?: Moment;
  status?: boolean;
}

export class Task implements ITask {
  constructor(
    public id?: number,
    public title?: string,
    public category?: string,
    public description?: string,
    public date?: Moment,
    public status?: boolean
  ) {
    this.status = this.status || false;
  }
}
