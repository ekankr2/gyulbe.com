export interface CreatePostRequest {
  title: string;
  subTitle: string;
  content: string;
}

export interface PageableRequest {
  page?: number;
  size?: number;
  sort?: string[];
}
