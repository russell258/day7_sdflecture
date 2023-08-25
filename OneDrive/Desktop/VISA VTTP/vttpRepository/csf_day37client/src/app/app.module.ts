import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';
import { UploadService } from './upload.service';
import { UploadComponent } from './components/upload.component';

@NgModule({
  declarations: [
    AppComponent,
    UploadComponent
  ],
  imports: [
    BrowserModule,ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [UploadService],
  bootstrap: [AppComponent]
})
export class AppModule { }
