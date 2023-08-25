import { Component, ElementRef, OnInit, ViewChild, inject } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UploadService } from './upload.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  fb = inject(FormBuilder);
  uploadSvc = inject(UploadService);
  router = inject(Router);
  route = inject(ActivatedRoute);
  id!: number;

  @ViewChild('toUpload')
  toUpload!:ElementRef

  uploadForm!:FormGroup

  ngOnInit(): void {
    this.uploadForm = this.fb.group(
      {
        description: this.fb.control<string>('')
      }
    )
  }

  processForm(){
    const value = this.uploadForm.value
    this.uploadSvc.upload(value['description'], this.toUpload)
                    .then(resp=> {
                      console.info('>>>> resp: ',resp);
                      this.id= resp.id;
                      this.router.navigate(['upload/',this.id],{relativeTo: this.route})
                    })
                    .catch(error=>{
                      console.error('error: ', error)
                    })
  }

}
