import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { ChakaJhipsterMonolithBankAccountModule } from './bank-account/bank-account.module';
import { ChakaJhipsterMonolithOperationModule } from './operation/operation.module';
import { ChakaJhipsterMonolithLabelModule } from './label/label.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        ChakaJhipsterMonolithBankAccountModule,
        ChakaJhipsterMonolithOperationModule,
        ChakaJhipsterMonolithLabelModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ChakaJhipsterMonolithEntityModule {}
