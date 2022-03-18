import { Injectable, Pipe, PipeTransform } from "@angular/core";

@Pipe({
  name: 'mycountryfilter',
  pure: false
})

export class MyFilterPipe implements PipeTransform {
  transform(items: any[], filter: any): any {
      if (!items || !filter) {
          return items;
      }
      return items.filter(item => item.title.indexOf(filter.title) !== -1);
    }}