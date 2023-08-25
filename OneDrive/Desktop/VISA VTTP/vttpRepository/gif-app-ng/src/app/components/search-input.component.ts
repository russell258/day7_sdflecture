import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GiphyService } from '../services/giphy.service';
import { Subscription } from 'rxjs';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-search-input',
  templateUrl: './search-input.component.html',
  styleUrls: ['./search-input.component.css']
})
export class SearchInputComponent {

  fb = inject(FormBuilder);
  svc = inject(GiphyService);
  sub$!: Subscription;
  giphyURL!: String;
  giphyURLArray: String[] =[];
  sanitizer = inject(DomSanitizer);

  searchForm!: FormGroup;

  ngOninit(){
    this.searchForm! = this.fb.group({
      searchTerm: this.fb.control('',[Validators.required,Validators.maxLength(50)])
    });
  }

  searchGiphy(){
    let searchFormatted = this.searchForm.value.searchTerm.replace('','+');
    console.log(searchFormatted);
    this.sub$ = this.svc.searchGiphy(searchFormatted).subscribe({
      next: (result) => {
        this.giphyURLArray=[];
        this.giphyURL =   JSON.parse(JSON.stringify(result)).data[0].images.original.url;
        for (let d of JSON.parse(JSON.stringify(result)).data){
          this.giphyURLArray.push(d.images.original.url);
        }
        console.log(this.giphyURLArray);
      },
      error: (error)=>{
        console.log(error);
      },
      complete:()=>{
        console.log('completed');
      },
    });
    this.sub$.unsubscribe;
  }

}
