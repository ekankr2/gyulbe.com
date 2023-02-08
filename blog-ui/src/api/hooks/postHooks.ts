import { useMutation, useQuery, useQueryClient } from '@tanstack/react-query';
import mainRequest from '../mainRequest';
import {
  CreatePostRequest,
  ErrorResponse,
  PageableRequest,
  PostInfo,
  PostListResponse,
  UpdatePostRequest,
} from '../types';
import { AxiosError } from 'axios';

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

export const useCreatePost = () => {
  const queryClient = useQueryClient();

  return useMutation(
    async (data: CreatePostRequest) => {
      const res = await mainRequest.post('/posts', data);
      return res.data;
    },
    {
      onSuccess: ({ data }) => {
        queryClient.invalidateQueries([PostKeys.postList]);
      },
      onError: (error: AxiosError<ErrorResponse>) => {
        if (error.response) console.error(error.response.data);
      },
    },
  );
};

export const useUpdatePost = () => {
  const queryClient = useQueryClient();

  return useMutation(
    async (request: UpdatePostRequest) => {
      const res = await mainRequest.put('/posts', request);
      return res.data;
    },
    {
      onSuccess: ({ data }) => {
        console.log(data);
        queryClient.invalidateQueries([PostKeys.postList]);
      },
    },
  );
};

export const useDeletePost = () => {
  const queryClient = useQueryClient();

  return useMutation(
    async (id: string) => {
      const res = await mainRequest.delete(`/posts/${id}`);
      return res.data;
    },
    {
      onSuccess: ({ data }) => {
        queryClient.invalidateQueries([PostKeys.postList]);
      },
      onError: (error: AxiosError<ErrorResponse>) => {
        if (error.response) console.error(error.response.data);
      },
    },
  );
};
