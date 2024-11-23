import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

// Add this before creating the router
const isAuthenticated = () => {
  return localStorage.getItem('isAuthenticated') === 'true'
}

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Dashboard',
      component: HomeView,
    },
    {
      path: '/profile',
      name: 'Profile',
      component: () => import('../views/ProfileView.vue'),
    },
    {
      path: '/benefits',
      name: 'Benefits',
      component: () => import('../views/BenefitsView.vue'),
    },
    {
      path: '/login',
      name: 'Login',
      component: () => import('../views/LoginView.vue'),
    },
    {
      path: '/register',
      name: 'Register',
      component: () => import('../views/RegisterView.vue'),
    },
    {
      path: '/adminDashboard',
      name: 'Admin Dashboard',
      component: () => import('../views/AdminView.vue'),
    },
  ],
})

// Add navigation guard
router.beforeEach((to, from, next) => {
  // List of public pages that don't require authentication
  const publicPages = ['/login', '/register']
  const authRequired = !publicPages.includes(to.path)

  if (authRequired && !isAuthenticated()) {
    return next('/login')
  }
  next()
})

export default router
