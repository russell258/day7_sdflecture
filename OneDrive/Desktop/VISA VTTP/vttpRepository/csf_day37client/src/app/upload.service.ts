import { HttpClient } from '@angular/common/http';
import { ElementRef, Injectable, inject } from '@angular/core';
import { firstValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UploadService {

  http = inject(HttpClient)

  //the uploadservice takes in 2 arguments, description and the first file referenced from nativeElement which
  // references the html directly and takes the .files from input type html element
  upload(description: string, elemRef:ElementRef): Promise<any>{
    console.info('>>> files: ', elemRef.nativeElement.files)

    //to create multipart
    const data = new FormData();
    data.set("description",description);
    data.set("myfile",elemRef.nativeElement.files[0])

    return firstValueFrom(
      this.http.post<any>('/upload',data)
    )

  }


}
