import { IOperation } from 'app/shared/model//operation.model';
import { IUser } from 'app/core/user/user.model';

export const enum BankAccountType {
    CURRENT_ACCOUNT = 'CURRENT_ACCOUNT',
    SAVING_ACCOUNT = 'SAVING_ACCOUNT'
}

export interface IBankAccount {
    id?: number;
    name?: string;
    balance?: number;
    type?: BankAccountType;
    operations?: IOperation[];
    user?: IUser;
}

export class BankAccount implements IBankAccount {
    constructor(
        public id?: number,
        public name?: string,
        public balance?: number,
        public type?: BankAccountType,
        public operations?: IOperation[],
        public user?: IUser
    ) {}
}
