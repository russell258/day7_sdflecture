import { Pipe, PipeTransform } from '@angular/core';
import { DomSanitizer, SafeHtml, SafeResourceUrl, SafeScript, SafeStyle, SafeUrl } from '@angular/platform-browser';

@Pipe({
  name: 'safety'
})
export class SafetyPipe implements PipeTransform {

    constructor(protected sanitizer: DomSanitizer){}

  public transform(value: any, type:string): SafeHtml | SafeStyle | SafeScript | SafeUrl | SafeResourceUrl {

  }

}
