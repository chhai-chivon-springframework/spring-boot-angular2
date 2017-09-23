

export class Category {

  constructor(
    ID: number,
    CATEGORY_NAME: string,
    DESCRIPTION: string
  ) {}


  fetchCategories(): Array<Category>{
    return [
      new Category(1, "", "")
    ];

    // return "http://localhost:9000/api/categories?limit=10";
  }


}
