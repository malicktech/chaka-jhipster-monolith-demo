import { Moment } from 'moment';
import { IBankAccount } from 'app/shared/model//bank-account.model';
import { ILabel } from 'app/shared/model//label.model';

export const enum OperationType {
    WITHDRAWAL = 'WITHDRAWAL',
    DEPOSIT = 'DEPOSIT',
    TRANSFER = 'TRANSFER'
}

export interface IOperation {
    id?: number;
    date?: Moment;
    description?: string;
    amount?: number;
    type?: OperationType;
    bankAccount?: IBankAccount;
    labels?: ILabel[];
}

export class Operation implements IOperation {
    constructor(
        public id?: number,
        public date?: Moment,
        public description?: string,
        public amount?: number,
        public type?: OperationType,
        public bankAccount?: IBankAccount,
        public labels?: ILabel[]
    ) {}
}
