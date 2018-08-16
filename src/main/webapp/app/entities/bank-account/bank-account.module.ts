import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ChakaJhipsterMonolithSharedModule } from 'app/shared';
import { ChakaJhipsterMonolithAdminModule } from 'app/admin/admin.module';
import { ChakaJhipsterMonolithOperationModule } from 'app/entities/operation/operation.module';

import {
    BankAccountComponent,
    BankAccountDetailComponent,
    BankAccountUpdateComponent,
    BankAccountDeletePopupComponent,
    BankAccountDeleteDialogComponent,
    bankAccountRoute,
    bankAccountPopupRoute
} from './';

const ENTITY_STATES = [...bankAccountRoute, ...bankAccountPopupRoute];

@NgModule({
    imports: [
        ChakaJhipsterMonolithSharedModule,
        ChakaJhipsterMonolithAdminModule,
        ChakaJhipsterMonolithOperationModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        BankAccountComponent,
        BankAccountDetailComponent,
        BankAccountUpdateComponent,
        BankAccountDeleteDialogComponent,
        BankAccountDeletePopupComponent
    ],
    entryComponents: [BankAccountComponent, BankAccountUpdateComponent, BankAccountDeleteDialogComponent, BankAccountDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ChakaJhipsterMonolithBankAccountModule {}
