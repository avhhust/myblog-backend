import NetworkProvider from './NetworkProvider';

class PostService {
  async getMostPopularPosts() {
    const posts = await NetworkProvider.getRequest('/top-posts');
    return posts.data;
  }

}

export default new PostService;