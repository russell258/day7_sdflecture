import { Component, inject } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent {
  imagePath!:string;
  route = inject(ActivatedRoute);

  ngOnInit(){
    this.route.params.subscribe(
      (params:Params) => {
        this.imagePath = 'https://csfday37.sgp1.digitaloceanspaces.com/' + params['id'];
        console.log(params['id']);
      }
    )
  }
}
