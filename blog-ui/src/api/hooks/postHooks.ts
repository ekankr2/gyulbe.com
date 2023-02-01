import { useQuery } from '@tanstack/react-query';
import mainRequest from '../mainRequest';
import { PageableRequest, PostInfo, PostListResponse } from '../types';

export const PostKeys = {
  postList: 'postList',
  postInfo: 'postInfo',
};

export const useGetPostList = ({ page = 0, size = 20, sort = ['id'] }: PageableRequest) => {
  return useQuery([PostKeys.postList], async () => {
    const { data } = await mainRequest.get<PostListResponse>(`/posts?page=${page}&size=${size}&sort=${sort}`);
    return data;
  });
};

export const useGetPostInfo = (id?: string) => {
  return useQuery(
    [PostKeys.postInfo, id],
    async () => {
      const { data } = await mainRequest.get<PostInfo>(`/posts/${id}`);
      return data;
    },
    { enabled: !!id },
  );
};
