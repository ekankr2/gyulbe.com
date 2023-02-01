export interface CreatePostRequest {
  title: string;
  subTitle: string;
  content: string;
}

// pageable types

export interface PageableRequest {
  page?: number;
  size?: number;
  sort?: string[];
}

export interface PageableResponse {
  content: any;
  empty: boolean;
  first: boolean;
  last: boolean;
  number: number;
  numberOfElements: number;
  pageable: any;
  size: number;
  sort: { empty: boolean; sorted: boolean; unsorted: boolean };
  totalElements: number;
  totalPages: number;
}

export interface PostListResponse extends PageableResponse {
  content: PostInfo[];
}

export interface PostInfo {
  id: string | number;
  title: string;
  subTitle: string;
  content: string;
  createdAt: any;
}

export interface ErrorResponse {
  detail: string;
}
