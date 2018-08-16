import { NgModule } from '@angular/core';

import { ChakaJhipsterMonolithSharedLibsModule, FindLanguageFromKeyPipe, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [ChakaJhipsterMonolithSharedLibsModule],
    declarations: [FindLanguageFromKeyPipe, JhiAlertComponent, JhiAlertErrorComponent],
    exports: [ChakaJhipsterMonolithSharedLibsModule, FindLanguageFromKeyPipe, JhiAlertComponent, JhiAlertErrorComponent]
})
export class ChakaJhipsterMonolithSharedCommonModule {}
