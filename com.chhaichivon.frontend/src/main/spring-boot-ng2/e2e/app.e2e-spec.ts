import { SpringBootAngular2Page } from './app.po';

describe('spring-boot-angular2 App', () => {
  let page: SpringBootAngular2Page;

  beforeEach(() => {
    page = new SpringBootAngular2Page();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
